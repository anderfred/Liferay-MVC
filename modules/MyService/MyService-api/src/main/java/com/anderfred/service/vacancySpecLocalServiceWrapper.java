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
 * Provides a wrapper for {@link vacancySpecLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see vacancySpecLocalService
 * @generated
 */
@ProviderType
public class vacancySpecLocalServiceWrapper
	implements vacancySpecLocalService,
			   ServiceWrapper<vacancySpecLocalService> {

	public vacancySpecLocalServiceWrapper(
		vacancySpecLocalService vacancySpecLocalService) {

		_vacancySpecLocalService = vacancySpecLocalService;
	}

	/**
	 * Adds the vacancy spec to the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was added
	 */
	@Override
	public com.anderfred.model.vacancySpec addvacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return _vacancySpecLocalService.addvacancySpec(vacancySpec);
	}

	/**
	 * Creates a new vacancy spec with the primary key. Does not add the vacancy spec to the database.
	 *
	 * @param id the primary key for the new vacancy spec
	 * @return the new vacancy spec
	 */
	@Override
	public com.anderfred.model.vacancySpec createvacancySpec(int id) {
		return _vacancySpecLocalService.createvacancySpec(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancySpecLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws PortalException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public com.anderfred.model.vacancySpec deletevacancySpec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancySpecLocalService.deletevacancySpec(id);
	}

	/**
	 * Deletes the vacancy spec from the database. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was removed
	 */
	@Override
	public com.anderfred.model.vacancySpec deletevacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return _vacancySpecLocalService.deletevacancySpec(vacancySpec);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _vacancySpecLocalService.dynamicQuery();
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

		return _vacancySpecLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _vacancySpecLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _vacancySpecLocalService.dynamicQuery(
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

		return _vacancySpecLocalService.dynamicQueryCount(dynamicQuery);
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

		return _vacancySpecLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.anderfred.model.vacancySpec fetchvacancySpec(int id) {
		return _vacancySpecLocalService.fetchvacancySpec(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _vacancySpecLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _vacancySpecLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _vacancySpecLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancySpecLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the vacancy spec with the primary key.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws PortalException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public com.anderfred.model.vacancySpec getvacancySpec(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _vacancySpecLocalService.getvacancySpec(id);
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
	@Override
	public java.util.List<com.anderfred.model.vacancySpec> getvacancySpecs(
		int start, int end) {

		return _vacancySpecLocalService.getvacancySpecs(start, end);
	}

	/**
	 * Returns the number of vacancy specs.
	 *
	 * @return the number of vacancy specs
	 */
	@Override
	public int getvacancySpecsCount() {
		return _vacancySpecLocalService.getvacancySpecsCount();
	}

	/**
	 * Updates the vacancy spec in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param vacancySpec the vacancy spec
	 * @return the vacancy spec that was updated
	 */
	@Override
	public com.anderfred.model.vacancySpec updatevacancySpec(
		com.anderfred.model.vacancySpec vacancySpec) {

		return _vacancySpecLocalService.updatevacancySpec(vacancySpec);
	}

	@Override
	public vacancySpecLocalService getWrappedService() {
		return _vacancySpecLocalService;
	}

	@Override
	public void setWrappedService(
		vacancySpecLocalService vacancySpecLocalService) {

		_vacancySpecLocalService = vacancySpecLocalService;
	}

	private vacancySpecLocalService _vacancySpecLocalService;

}