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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link vacancyAreaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see vacancyAreaLocalService
 * @generated
 */
@ProviderType
public class vacancyAreaLocalServiceWrapper
	implements vacancyAreaLocalService,
			   ServiceWrapper<vacancyAreaLocalService> {

	public vacancyAreaLocalServiceWrapper(
		vacancyAreaLocalService vacancyAreaLocalService) {

		_vacancyAreaLocalService = vacancyAreaLocalService;
	}

	/**
	 * Adds the vacancy area to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancyArea the vacancy area
	 * @return the vacancy area that was added
	 */
	@Override
	public com.anderfred.model.vacancyArea addvacancyArea(
		com.anderfred.model.vacancyArea vacancyArea) {

		return _vacancyAreaLocalService.addvacancyArea(vacancyArea);
	}

	/**
	 * Creates a new vacancy area with the primary key. Does not add the vacancy area to the database.
	 *
	 * @param id the primary key for the new vacancy area
	 * @return the new vacancy area
	 */
	@Override
	public com.anderfred.model.vacancyArea createvacancyArea(int id) {
		return _vacancyAreaLocalService.createvacancyArea(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancyAreaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vacancy area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy area
	 * @return the vacancy area that was removed
	 * @throws PortalException if a vacancy area with the primary key could not be found
	 */
	@Override
	public com.anderfred.model.vacancyArea deletevacancyArea(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancyAreaLocalService.deletevacancyArea(id);
	}

	/**
	 * Deletes the vacancy area from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancyArea the vacancy area
	 * @return the vacancy area that was removed
	 */
	@Override
	public com.anderfred.model.vacancyArea deletevacancyArea(
		com.anderfred.model.vacancyArea vacancyArea) {

		return _vacancyAreaLocalService.deletevacancyArea(vacancyArea);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vacancyAreaLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vacancyAreaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _vacancyAreaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _vacancyAreaLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _vacancyAreaLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _vacancyAreaLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.anderfred.model.vacancyArea fetchvacancyArea(int id) {
		return _vacancyAreaLocalService.fetchvacancyArea(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vacancyAreaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vacancyAreaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vacancyAreaLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancyAreaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vacancy area with the primary key.
	 *
	 * @param id the primary key of the vacancy area
	 * @return the vacancy area
	 * @throws PortalException if a vacancy area with the primary key could not be found
	 */
	@Override
	public com.anderfred.model.vacancyArea getvacancyArea(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancyAreaLocalService.getvacancyArea(id);
	}

	/**
	 * Returns a range of all the vacancy areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.anderfred.model.impl.vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy areas
	 * @param end the upper bound of the range of vacancy areas (not inclusive)
	 * @return the range of vacancy areas
	 */
	@Override
	public java.util.List<com.anderfred.model.vacancyArea> getvacancyAreas(
		int start, int end) {

		return _vacancyAreaLocalService.getvacancyAreas(start, end);
	}

	/**
	 * Returns the number of vacancy areas.
	 *
	 * @return the number of vacancy areas
	 */
	@Override
	public int getvacancyAreasCount() {
		return _vacancyAreaLocalService.getvacancyAreasCount();
	}

	/**
	 * Updates the vacancy area in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vacancyArea the vacancy area
	 * @return the vacancy area that was updated
	 */
	@Override
	public com.anderfred.model.vacancyArea updatevacancyArea(
		com.anderfred.model.vacancyArea vacancyArea) {

		return _vacancyAreaLocalService.updatevacancyArea(vacancyArea);
	}

	@Override
	public vacancyAreaLocalService getWrappedService() {
		return _vacancyAreaLocalService;
	}

	@Override
	public void setWrappedService(
		vacancyAreaLocalService vacancyAreaLocalService) {

		_vacancyAreaLocalService = vacancyAreaLocalService;
	}

	private vacancyAreaLocalService _vacancyAreaLocalService;

}