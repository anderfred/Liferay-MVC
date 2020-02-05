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
 * This class is a wrapper for {@link Vacancy}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vacancy
 * @generated
 */
@ProviderType
public class VacancyWrapper
	extends BaseModelWrapper<Vacancy>
	implements Vacancy, ModelWrapper<Vacancy> {

	public VacancyWrapper(Vacancy vacancy) {
		super(vacancy);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("publishedDate", getPublishedDate());
		attributes.put("employer", getEmployer());
		attributes.put("text", getText());
		attributes.put("salary", getSalary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String publishedDate = (String)attributes.get("publishedDate");

		if (publishedDate != null) {
			setPublishedDate(publishedDate);
		}

		String employer = (String)attributes.get("employer");

		if (employer != null) {
			setEmployer(employer);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		String salary = (String)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}
	}

	/**
	 * Returns the employer of this vacancy.
	 *
	 * @return the employer of this vacancy
	 */
	@Override
	public String getEmployer() {
		return model.getEmployer();
	}

	/**
	 * Returns the ID of this vacancy.
	 *
	 * @return the ID of this vacancy
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this vacancy.
	 *
	 * @return the primary key of this vacancy
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the published date of this vacancy.
	 *
	 * @return the published date of this vacancy
	 */
	@Override
	public String getPublishedDate() {
		return model.getPublishedDate();
	}

	/**
	 * Returns the salary of this vacancy.
	 *
	 * @return the salary of this vacancy
	 */
	@Override
	public String getSalary() {
		return model.getSalary();
	}

	/**
	 * Returns the text of this vacancy.
	 *
	 * @return the text of this vacancy
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the employer of this vacancy.
	 *
	 * @param employer the employer of this vacancy
	 */
	@Override
	public void setEmployer(String employer) {
		model.setEmployer(employer);
	}

	/**
	 * Sets the ID of this vacancy.
	 *
	 * @param id the ID of this vacancy
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this vacancy.
	 *
	 * @param primaryKey the primary key of this vacancy
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the published date of this vacancy.
	 *
	 * @param publishedDate the published date of this vacancy
	 */
	@Override
	public void setPublishedDate(String publishedDate) {
		model.setPublishedDate(publishedDate);
	}

	/**
	 * Sets the salary of this vacancy.
	 *
	 * @param salary the salary of this vacancy
	 */
	@Override
	public void setSalary(String salary) {
		model.setSalary(salary);
	}

	/**
	 * Sets the text of this vacancy.
	 *
	 * @param text the text of this vacancy
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	@Override
	protected VacancyWrapper wrap(Vacancy vacancy) {
		return new VacancyWrapper(vacancy);
	}

}