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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link vacancyArea}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancyArea
 * @generated
 */
@ProviderType
public class vacancyAreaWrapper
	extends BaseModelWrapper<vacancyArea>
	implements vacancyArea, ModelWrapper<vacancyArea> {

	public vacancyAreaWrapper(vacancyArea vacancyArea) {
		super(vacancyArea);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the ID of this vacancy area.
	 *
	 * @return the ID of this vacancy area
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this vacancy area.
	 *
	 * @return the name of this vacancy area
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this vacancy area.
	 *
	 * @return the primary key of this vacancy area
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ID of this vacancy area.
	 *
	 * @param id the ID of this vacancy area
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this vacancy area.
	 *
	 * @param name the name of this vacancy area
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this vacancy area.
	 *
	 * @param primaryKey the primary key of this vacancy area
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected vacancyAreaWrapper wrap(vacancyArea vacancyArea) {
		return new vacancyAreaWrapper(vacancyArea);
	}

}