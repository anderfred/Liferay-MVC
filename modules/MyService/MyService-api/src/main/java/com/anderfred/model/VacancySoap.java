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

import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VacancySoap implements Serializable {

	public static VacancySoap toSoapModel(Vacancy model) {
		VacancySoap soapModel = new VacancySoap();

		soapModel.setId(model.getId());
		soapModel.setPublishedDate(model.getPublishedDate());
		soapModel.setEmployer(model.getEmployer());
		soapModel.setText(model.getText());
		soapModel.setSalary(model.getSalary());
		soapModel.setArea(model.getArea());
		soapModel.setSpec(model.getSpec());

		return soapModel;
	}

	public static VacancySoap[] toSoapModels(Vacancy[] models) {
		VacancySoap[] soapModels = new VacancySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[][] toSoapModels(Vacancy[][] models) {
		VacancySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VacancySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VacancySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VacancySoap[] toSoapModels(List<Vacancy> models) {
		List<VacancySoap> soapModels = new ArrayList<VacancySoap>(
			models.size());

		for (Vacancy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VacancySoap[soapModels.size()]);
	}

	public VacancySoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Date getPublishedDate() {
		return _publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		_publishedDate = publishedDate;
	}

	public String getEmployer() {
		return _employer;
	}

	public void setEmployer(String employer) {
		_employer = employer;
	}

	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}

	public String getSalary() {
		return _salary;
	}

	public void setSalary(String salary) {
		_salary = salary;
	}

	public int getArea() {
		return _area;
	}

	public void setArea(int area) {
		_area = area;
	}

	public int getSpec() {
		return _spec;
	}

	public void setSpec(int spec) {
		_spec = spec;
	}

	private int _id;
	private Date _publishedDate;
	private String _employer;
	private String _text;
	private String _salary;
	private int _area;
	private int _spec;

}