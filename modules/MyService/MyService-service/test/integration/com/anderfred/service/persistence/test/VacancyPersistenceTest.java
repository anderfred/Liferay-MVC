/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.anderfred.service.persistence.test;

import com.anderfred.exception.NoSuchVacancyException;
import com.anderfred.model.Vacancy;
import com.anderfred.service.VacancyLocalServiceUtil;
import com.anderfred.service.persistence.VacancyPersistence;
import com.anderfred.service.persistence.VacancyUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class VacancyPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.anderfred.service"));

	@Before
	public void setUp() {
		_persistence = VacancyUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Vacancy> iterator = _vacancies.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Vacancy vacancy = _persistence.create(pk);

		Assert.assertNotNull(vacancy);

		Assert.assertEquals(vacancy.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Vacancy newVacancy = addVacancy();

		_persistence.remove(newVacancy);

		Vacancy existingVacancy = _persistence.fetchByPrimaryKey(
			newVacancy.getPrimaryKey());

		Assert.assertNull(existingVacancy);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addVacancy();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Vacancy newVacancy = _persistence.create(pk);

		newVacancy.setPublishedDate(RandomTestUtil.randomString());

		newVacancy.setEmployer(RandomTestUtil.randomString());

		newVacancy.setText(RandomTestUtil.randomString());

		newVacancy.setSalary(RandomTestUtil.randomString());

		_vacancies.add(_persistence.update(newVacancy));

		Vacancy existingVacancy = _persistence.findByPrimaryKey(
			newVacancy.getPrimaryKey());

		Assert.assertEquals(existingVacancy.getId(), newVacancy.getId());
		Assert.assertEquals(
			existingVacancy.getPublishedDate(), newVacancy.getPublishedDate());
		Assert.assertEquals(
			existingVacancy.getEmployer(), newVacancy.getEmployer());
		Assert.assertEquals(existingVacancy.getText(), newVacancy.getText());
		Assert.assertEquals(
			existingVacancy.getSalary(), newVacancy.getSalary());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Vacancy newVacancy = addVacancy();

		Vacancy existingVacancy = _persistence.findByPrimaryKey(
			newVacancy.getPrimaryKey());

		Assert.assertEquals(existingVacancy, newVacancy);
	}

	@Test(expected = NoSuchVacancyException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Vacancy> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"vacancy", "id", true, "publishedDate", true, "employer", true,
			"text", true, "salary", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Vacancy newVacancy = addVacancy();

		Vacancy existingVacancy = _persistence.fetchByPrimaryKey(
			newVacancy.getPrimaryKey());

		Assert.assertEquals(existingVacancy, newVacancy);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Vacancy missingVacancy = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingVacancy);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Vacancy newVacancy1 = addVacancy();
		Vacancy newVacancy2 = addVacancy();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVacancy1.getPrimaryKey());
		primaryKeys.add(newVacancy2.getPrimaryKey());

		Map<Serializable, Vacancy> vacancies = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, vacancies.size());
		Assert.assertEquals(
			newVacancy1, vacancies.get(newVacancy1.getPrimaryKey()));
		Assert.assertEquals(
			newVacancy2, vacancies.get(newVacancy2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		int pk1 = RandomTestUtil.nextInt();

		int pk2 = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Vacancy> vacancies = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(vacancies.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Vacancy newVacancy = addVacancy();

		int pk = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVacancy.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Vacancy> vacancies = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, vacancies.size());
		Assert.assertEquals(
			newVacancy, vacancies.get(newVacancy.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Vacancy> vacancies = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(vacancies.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Vacancy newVacancy = addVacancy();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newVacancy.getPrimaryKey());

		Map<Serializable, Vacancy> vacancies = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, vacancies.size());
		Assert.assertEquals(
			newVacancy, vacancies.get(newVacancy.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			VacancyLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Vacancy>() {

				@Override
				public void performAction(Vacancy vacancy) {
					Assert.assertNotNull(vacancy);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Vacancy newVacancy = addVacancy();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vacancy.class, _dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("id", newVacancy.getId()));

		List<Vacancy> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Vacancy existingVacancy = result.get(0);

		Assert.assertEquals(existingVacancy, newVacancy);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vacancy.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextInt()));

		List<Vacancy> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Vacancy newVacancy = addVacancy();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vacancy.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newVacancy.getId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id", new Object[] {newId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingId = result.get(0);

		Assert.assertEquals(existingId, newId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Vacancy.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextInt()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Vacancy addVacancy() throws Exception {
		int pk = RandomTestUtil.nextInt();

		Vacancy vacancy = _persistence.create(pk);

		vacancy.setPublishedDate(RandomTestUtil.randomString());

		vacancy.setEmployer(RandomTestUtil.randomString());

		vacancy.setText(RandomTestUtil.randomString());

		vacancy.setSalary(RandomTestUtil.randomString());

		_vacancies.add(_persistence.update(vacancy));

		return vacancy;
	}

	private List<Vacancy> _vacancies = new ArrayList<Vacancy>();
	private VacancyPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}