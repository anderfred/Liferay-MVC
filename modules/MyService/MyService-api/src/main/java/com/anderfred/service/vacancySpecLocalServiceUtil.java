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

package com.anderfred.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for vacancySpec. This utility wraps
 * <code>com.anderfred.service.impl.vacancySpecLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see vacancySpecLocalService
 * @generated
 */
@ProviderType
public class vacancySpecLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.anderfred.service.impl.vacancySpecLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the vacancy spec to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was added
	 */
	public static com.anderfred.model.vacancySpec addvacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return getService().addvacancySpec(vacancySpec);
	}

	/**
	 * Creates a new vacancy spec with the primary key. Does not add the vacancy spec to the database.
	 *
	 * @param id the primary key for the new vacancy spec
	 * @return the new vacancy spec
	 */
	public static com.anderfred.model.vacancySpec createvacancySpec(int id) {
		return getService().createvacancySpec(id);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws PortalException if a vacancy spec with the primary key could not be found
	 */
	public static com.anderfred.model.vacancySpec deletevacancySpec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletevacancySpec(id);
	}

	/**
	 * Deletes the vacancy spec from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was removed
	 */
	public static com.anderfred.model.vacancySpec deletevacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return getService().deletevacancySpec(vacancySpec);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.anderfred.model.vacancySpec fetchvacancySpec(int id) {
		return getService().fetchvacancySpec(id);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vacancy spec with the primary key.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws PortalException if a vacancy spec with the primary key could not be found
	 */
	public static com.anderfred.model.vacancySpec getvacancySpec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getvacancySpec(id);
	}

	/**
	 * Returns a range of all the vacancy specs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancySpecModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy specs
	 * @param end the upper bound of the range of vacancy specs (not inclusive)
	 * @return the range of vacancy specs
	 */
	public static java.util.List<com.anderfred.model.vacancySpec>
		getvacancySpecs(int start, int end) {

		return getService().getvacancySpecs(start, end);
	}

	/**
	 * Returns the number of vacancy specs.
	 *
	 * @return the number of vacancy specs
	 */
	public static int getvacancySpecsCount() {
		return getService().getvacancySpecsCount();
	}

	/**
	 * Updates the vacancy spec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was updated
	 */
	public static com.anderfred.model.vacancySpec updatevacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return getService().updatevacancySpec(vacancySpec);
	}

	public static vacancySpecLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<vacancySpecLocalService, vacancySpecLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(vacancySpecLocalService.class);

		ServiceTracker<vacancySpecLocalService, vacancySpecLocalService>
			serviceTracker =
				new ServiceTracker
					<vacancySpecLocalService, vacancySpecLocalService>(
						bundle.getBundleContext(),
						vacancySpecLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}