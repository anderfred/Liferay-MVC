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

package com.anderfred.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the vacancyArea service. Represents a row in the &quot;vacancyArea&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.anderfred.model.impl.vacancyAreaModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.anderfred.model.impl.vacancyAreaImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancyArea
 * @generated
 */
@ProviderType
public interface vacancyAreaModel extends BaseModel<vacancyArea> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a vacancy area model instance should use the {@link vacancyArea} interface instead.
	 */

	/**
	 * Returns the primary key of this vacancy area.
	 *
	 * @return the primary key of this vacancy area
	 */
	public int getPrimaryKey();

	/**
	 * Sets the primary key of this vacancy area.
	 *
	 * @param primaryKey the primary key of this vacancy area
	 */
	public void setPrimaryKey(int primaryKey);

	/**
	 * Returns the ID of this vacancy area.
	 *
	 * @return the ID of this vacancy area
	 */
	public int getId();

	/**
	 * Sets the ID of this vacancy area.
	 *
	 * @param id the ID of this vacancy area
	 */
	public void setId(int id);

	/**
	 * Returns the name of this vacancy area.
	 *
	 * @return the name of this vacancy area
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this vacancy area.
	 *
	 * @param name the name of this vacancy area
	 */
	public void setName(String name);

}