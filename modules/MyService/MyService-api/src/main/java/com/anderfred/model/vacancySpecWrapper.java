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
 * This class is a wrapper for {@link vacancySpec}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see vacancySpec
 * @generated
 */
@ProviderType
public class vacancySpecWrapper
	extends BaseModelWrapper<vacancySpec>
	implements vacancySpec, ModelWrapper<vacancySpec> {

	public vacancySpecWrapper(vacancySpec vacancySpec) {
		super(vacancySpec);
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
	 * Returns the ID of this vacancy spec.
	 *
	 * @return the ID of this vacancy spec
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this vacancy spec.
	 *
	 * @return the name of this vacancy spec
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this vacancy spec.
	 *
	 * @return the primary key of this vacancy spec
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
	 * Sets the ID of this vacancy spec.
	 *
	 * @param id the ID of this vacancy spec
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this vacancy spec.
	 *
	 * @param name the name of this vacancy spec
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this vacancy spec.
	 *
	 * @param primaryKey the primary key of this vacancy spec
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected vacancySpecWrapper wrap(vacancySpec vacancySpec) {
		return new vacancySpecWrapper(vacancySpec);
	}

}