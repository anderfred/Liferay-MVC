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

import com.anderfred.exception.NoSuchvacancySpecException;
import com.anderfred.model.vacancySpec;
import com.anderfred.service.persistence.vacancySpecPersistence;
import com.anderfred.service.persistence.vacancySpecUtil;
import com.anderfred.service.vacancySpecLocalServiceUtil;

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
public class vacancySpecPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.anderfred.service"));

	@Before
	public void setUp() {
		_persistence = vacancySpecUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<vacancySpec> iterator = _vacancySpecs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancySpec vacancySpec = _persistence.create(pk);

		Assert.assertNotNull(vacancySpec);

		Assert.assertEquals(vacancySpec.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		_persistence.remove(newvacancySpec);

		vacancySpec existingvacancySpec = _persistence.fetchByPrimaryKey(
			newvacancySpec.getPrimaryKey());

		Assert.assertNull(existingvacancySpec);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addvacancySpec();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancySpec newvacancySpec = _persistence.create(pk);

		newvacancySpec.setName(RandomTestUtil.randomString());

		_vacancySpecs.add(_persistence.update(newvacancySpec));

		vacancySpec existingvacancySpec = _persistence.findByPrimaryKey(
			newvacancySpec.getPrimaryKey());

		Assert.assertEquals(
			existingvacancySpec.getId(), newvacancySpec.getId());
		Assert.assertEquals(
			existingvacancySpec.getName(), newvacancySpec.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		vacancySpec existingvacancySpec = _persistence.findByPrimaryKey(
			newvacancySpec.getPrimaryKey());

		Assert.assertEquals(existingvacancySpec, newvacancySpec);
	}

	@Test(expected = NoSuchvacancySpecException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<vacancySpec> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"vacancySpec", "id", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		vacancySpec existingvacancySpec = _persistence.fetchByPrimaryKey(
			newvacancySpec.getPrimaryKey());

		Assert.assertEquals(existingvacancySpec, newvacancySpec);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancySpec missingvacancySpec = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingvacancySpec);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		vacancySpec newvacancySpec1 = addvacancySpec();
		vacancySpec newvacancySpec2 = addvacancySpec();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancySpec1.getPrimaryKey());
		primaryKeys.add(newvacancySpec2.getPrimaryKey());

		Map<Serializable, vacancySpec> vacancySpecs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, vacancySpecs.size());
		Assert.assertEquals(
			newvacancySpec1, vacancySpecs.get(newvacancySpec1.getPrimaryKey()));
		Assert.assertEquals(
			newvacancySpec2, vacancySpecs.get(newvacancySpec2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		int pk1 = RandomTestUtil.nextInt();

		int pk2 = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, vacancySpec> vacancySpecs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vacancySpecs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		vacancySpec newvacancySpec = addvacancySpec();

		int pk = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancySpec.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, vacancySpec> vacancySpecs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vacancySpecs.size());
		Assert.assertEquals(
			newvacancySpec, vacancySpecs.get(newvacancySpec.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, vacancySpec> vacancySpecs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vacancySpecs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancySpec.getPrimaryKey());

		Map<Serializable, vacancySpec> vacancySpecs =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vacancySpecs.size());
		Assert.assertEquals(
			newvacancySpec, vacancySpecs.get(newvacancySpec.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			vacancySpecLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<vacancySpec>() {

				@Override
				public void performAction(vacancySpec vacancySpec) {
					Assert.assertNotNull(vacancySpec);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancySpec.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newvacancySpec.getId()));

		List<vacancySpec> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		vacancySpec existingvacancySpec = result.get(0);

		Assert.assertEquals(existingvacancySpec, newvacancySpec);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancySpec.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextInt()));

		List<vacancySpec> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		vacancySpec newvacancySpec = addvacancySpec();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancySpec.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newvacancySpec.getId();

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
			vacancySpec.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextInt()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected vacancySpec addvacancySpec() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancySpec vacancySpec = _persistence.create(pk);

		vacancySpec.setName(RandomTestUtil.randomString());

		_vacancySpecs.add(_persistence.update(vacancySpec));

		return vacancySpec;
	}

	private List<vacancySpec> _vacancySpecs = new ArrayList<vacancySpec>();
	private vacancySpecPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}