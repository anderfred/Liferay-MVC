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

import com.anderfred.exception.NoSuchvacancyAreaException;
import com.anderfred.model.vacancyArea;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the vacancy area service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancyAreaUtil
 * @generated
 */
@ProviderType
public interface vacancyAreaPersistence extends BasePersistence<vacancyArea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vacancyAreaUtil} to access the vacancy area persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the vacancy area in the entity cache if it is enabled.
	 *
	 * @param vacancyArea the vacancy area
	 */
	public void cacheResult(vacancyArea vacancyArea);

	/**
	 * Caches the vacancy areas in the entity cache if it is enabled.
	 *
	 * @param vacancyAreas the vacancy areas
	 */
	public void cacheResult(java.util.List<vacancyArea> vacancyAreas);

	/**
	 * Creates a new vacancy area with the primary key. Does not add the vacancy area to the database.
	 *
	 * @param id the primary key for the new vacancy area
	 * @return the new vacancy area
	 */
	public vacancyArea create(int id);

	/**
	 * Removes the vacancy area with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy area
	 * @return the vacancy area that was removed
	 * @throws NoSuchvacancyAreaException if a vacancy area with the primary key could not be found
	 */
	public vacancyArea remove(int id) throws NoSuchvacancyAreaException;

	public vacancyArea updateImpl(vacancyArea vacancyArea);

	/**
	 * Returns the vacancy area with the primary key or throws a <code>NoSuchvacancyAreaException</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy area
	 * @return the vacancy area
	 * @throws NoSuchvacancyAreaException if a vacancy area with the primary key could not be found
	 */
	public vacancyArea findByPrimaryKey(int id)
		throws NoSuchvacancyAreaException;

	/**
	 * Returns the vacancy area with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy area
	 * @return the vacancy area, or <code>null</code> if a vacancy area with the primary key could not be found
	 */
	public vacancyArea fetchByPrimaryKey(int id);

	/**
	 * Returns all the vacancy areas.
	 *
	 * @return the vacancy areas
	 */
	public java.util.List<vacancyArea> findAll();

	/**
	 * Returns a range of all the vacancy areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy areas
	 * @param end the upper bound of the range of vacancy areas (not inclusive)
	 * @return the range of vacancy areas
	 */
	public java.util.List<vacancyArea> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the vacancy areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of vacancy areas
	 * @param end the upper bound of the range of vacancy areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of vacancy areas
	 */
	@Deprecated
	public java.util.List<vacancyArea> findAll(
		int start, int end, OrderByComparator<vacancyArea> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the vacancy areas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>vacancyAreaModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of vacancy areas
	 * @param end the upper bound of the range of vacancy areas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of vacancy areas
	 */
	public java.util.List<vacancyArea> findAll(
		int start, int end, OrderByComparator<vacancyArea> orderByComparator);

	/**
	 * Removes all the vacancy areas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vacancy areas.
	 *
	 * @return the number of vacancy areas
	 */
	public int countAll();

}