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

import com.anderfred.exception.NoSuchvacancySpecException;
import com.anderfred.model.vacancySpec;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the vacancy spec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancySpecUtil
 * @generated
 */
@ProviderType
public interface vacancySpecPersistence extends BasePersistence<vacancySpec> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link vacancySpecUtil} to access the vacancy spec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the vacancy spec in the entity cache if it is enabled.
	 *
	 * @param vacancySpec the vacancy spec
	 */
	public void cacheResult(vacancySpec vacancySpec);

	/**
	 * Caches the vacancy specs in the entity cache if it is enabled.
	 *
	 * @param vacancySpecs the vacancy specs
	 */
	public void cacheResult(java.util.List<vacancySpec> vacancySpecs);

	/**
	 * Creates a new vacancy spec with the primary key. Does not add the vacancy spec to the database.
	 *
	 * @param id the primary key for the new vacancy spec
	 * @return the new vacancy spec
	 */
	public vacancySpec create(int id);

	/**
	 * Removes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	public vacancySpec remove(int id) throws NoSuchvacancySpecException;

	public vacancySpec updateImpl(vacancySpec vacancySpec);

	/**
	 * Returns the vacancy spec with the primary key or throws a <code>NoSuchvacancySpecException</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	public vacancySpec findByPrimaryKey(int id)
		throws NoSuchvacancySpecException;

	/**
	 * Returns the vacancy spec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec, or <code>null</code> if a vacancy spec with the primary key could not be found
	 */
	public vacancySpec fetchByPrimaryKey(int id);

	/**
	 * Returns all the vacancy specs.
	 *
	 * @return the vacancy specs
	 */
	public java.util.List<vacancySpec> findAll();

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
	public java.util.List<vacancySpec> findAll(int start, int end);

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
	public java.util.List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator);

	/**
	 * Removes all the vacancy specs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of vacancy specs.
	 *
	 * @return the number of vacancy specs
	 */
	public int countAll();

}