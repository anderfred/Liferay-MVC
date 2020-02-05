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

package com.anderfred.service.persistence;

import com.anderfred.model.vacancySpec;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the vacancy spec service. This utility wraps <code>com.anderfred.service.persistence.impl.vacancySpecPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancySpecPersistence
 * @generated
 */
@ProviderType
public class vacancySpecUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(vacancySpec vacancySpec) {
		getPersistence().clearCache(vacancySpec);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, vacancySpec> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<vacancySpec> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<vacancySpec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<vacancySpec> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<vacancySpec> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static vacancySpec update(vacancySpec vacancySpec) {
		return getPersistence().update(vacancySpec);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static vacancySpec update(
		vacancySpec vacancySpec, ServiceContext serviceContext) {

		return getPersistence().update(vacancySpec, serviceContext);
	}

	/**
	 * Caches the vacancy spec in the entity cache if it is enabled.
	 *
	 * @param vacancySpec the vacancy spec
	 */
	public static void cacheResult(vacancySpec vacancySpec) {
		getPersistence().cacheResult(vacancySpec);
	}

	/**
	 * Caches the vacancy specs in the entity cache if it is enabled.
	 *
	 * @param vacancySpecs the vacancy specs
	 */
	public static void cacheResult(List<vacancySpec> vacancySpecs) {
		getPersistence().cacheResult(vacancySpecs);
	}

	/**
	 * Creates a new vacancy spec with the primary key. Does not add the vacancy spec to the database.
	 *
	 * @param id the primary key for the new vacancy spec
	 * @return the new vacancy spec
	 */
	public static vacancySpec create(int id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	public static vacancySpec remove(int id)
		throws com.anderfred.exception.NoSuchvacancySpecException {

		return getPersistence().remove(id);
	}

	public static vacancySpec updateImpl(vacancySpec vacancySpec) {
		return getPersistence().updateImpl(vacancySpec);
	}

	/**
	 * Returns the vacancy spec with the primary key or throws a <code>NoSuchvacancySpecException</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	public static vacancySpec findByPrimaryKey(int id)
		throws com.anderfred.exception.NoSuchvacancySpecException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the vacancy spec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec, or <code>null</code> if a vacancy spec with the primary key could not be found
	 */
	public static vacancySpec fetchByPrimaryKey(int id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the vacancy specs.
	 *
	 * @return the vacancy specs
	 */
	public static List<vacancySpec> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the vacancy specs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy specs
	 * @param end the upper bound of the range of vacancy specs (not inclusive)
	 * @return the range of vacancy specs
	 */
	public static List<vacancySpec> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the vacancy specs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of vacancy specs
	 * @param end the upper bound of the range of vacancy specs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vacancy specs
	 */
	@Deprecated
	public static List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the vacancy specs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy specs
	 * @param end the upper bound of the range of vacancy specs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacancy specs
	 */
	public static List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the vacancy specs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of vacancy specs.
	 *
	 * @return the number of vacancy specs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static vacancySpecPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<vacancySpecPersistence, vacancySpecPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(vacancySpecPersistence.class);

		ServiceTracker<vacancySpecPersistence, vacancySpecPersistence>
			serviceTracker =
				new ServiceTracker
					<vacancySpecPersistence, vacancySpecPersistence>(
						bundle.getBundleContext(), vacancySpecPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}