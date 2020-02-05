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

import com.anderfred.exception.NoSuchvacancyAreaException;
import com.anderfred.model.vacancyArea;
import com.anderfred.service.persistence.vacancyAreaPersistence;
import com.anderfred.service.persistence.vacancyAreaUtil;
import com.anderfred.service.vacancyAreaLocalServiceUtil;

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
public class vacancyAreaPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.anderfred.service"));

	@Before
	public void setUp() {
		_persistence = vacancyAreaUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<vacancyArea> iterator = _vacancyAreas.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancyArea vacancyArea = _persistence.create(pk);

		Assert.assertNotNull(vacancyArea);

		Assert.assertEquals(vacancyArea.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		_persistence.remove(newvacancyArea);

		vacancyArea existingvacancyArea = _persistence.fetchByPrimaryKey(
			newvacancyArea.getPrimaryKey());

		Assert.assertNull(existingvacancyArea);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addvacancyArea();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancyArea newvacancyArea = _persistence.create(pk);

		newvacancyArea.setName(RandomTestUtil.randomString());

		_vacancyAreas.add(_persistence.update(newvacancyArea));

		vacancyArea existingvacancyArea = _persistence.findByPrimaryKey(
			newvacancyArea.getPrimaryKey());

		Assert.assertEquals(
			existingvacancyArea.getId(), newvacancyArea.getId());
		Assert.assertEquals(
			existingvacancyArea.getName(), newvacancyArea.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		vacancyArea existingvacancyArea = _persistence.findByPrimaryKey(
			newvacancyArea.getPrimaryKey());

		Assert.assertEquals(existingvacancyArea, newvacancyArea);
	}

	@Test(expected = NoSuchvacancyAreaException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<vacancyArea> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"vacancyArea", "id", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		vacancyArea existingvacancyArea = _persistence.fetchByPrimaryKey(
			newvacancyArea.getPrimaryKey());

		Assert.assertEquals(existingvacancyArea, newvacancyArea);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancyArea missingvacancyArea = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingvacancyArea);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		vacancyArea newvacancyArea1 = addvacancyArea();
		vacancyArea newvacancyArea2 = addvacancyArea();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancyArea1.getPrimaryKey());
		primaryKeys.add(newvacancyArea2.getPrimaryKey());

		Map<Serializable, vacancyArea> vacancyAreas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, vacancyAreas.size());
		Assert.assertEquals(
			newvacancyArea1, vacancyAreas.get(newvacancyArea1.getPrimaryKey()));
		Assert.assertEquals(
			newvacancyArea2, vacancyAreas.get(newvacancyArea2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		int pk1 = RandomTestUtil.nextInt();

		int pk2 = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, vacancyArea> vacancyAreas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vacancyAreas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		vacancyArea newvacancyArea = addvacancyArea();

		int pk = RandomTestUtil.nextInt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancyArea.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, vacancyArea> vacancyAreas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vacancyAreas.size());
		Assert.assertEquals(
			newvacancyArea, vacancyAreas.get(newvacancyArea.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, vacancyArea> vacancyAreas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(vacancyAreas.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newvacancyArea.getPrimaryKey());

		Map<Serializable, vacancyArea> vacancyAreas =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, vacancyAreas.size());
		Assert.assertEquals(
			newvacancyArea, vacancyAreas.get(newvacancyArea.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			vacancyAreaLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<vacancyArea>() {

				@Override
				public void performAction(vacancyArea vacancyArea) {
					Assert.assertNotNull(vacancyArea);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancyArea.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", newvacancyArea.getId()));

		List<vacancyArea> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		vacancyArea existingvacancyArea = result.get(0);

		Assert.assertEquals(existingvacancyArea, newvacancyArea);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancyArea.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id", RandomTestUtil.nextInt()));

		List<vacancyArea> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		vacancyArea newvacancyArea = addvacancyArea();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			vacancyArea.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		Object newId = newvacancyArea.getId();

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
			vacancyArea.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id", new Object[] {RandomTestUtil.nextInt()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected vacancyArea addvacancyArea() throws Exception {
		int pk = RandomTestUtil.nextInt();

		vacancyArea vacancyArea = _persistence.create(pk);

		vacancyArea.setName(RandomTestUtil.randomString());

		_vacancyAreas.add(_persistence.update(vacancyArea));

		return vacancyArea;
	}

	private List<vacancyArea> _vacancyAreas = new ArrayList<vacancyArea>();
	private vacancyAreaPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}