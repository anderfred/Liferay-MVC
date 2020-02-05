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

package com.anderfred.model.impl;

import com.anderfred.model.Vacancy;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Vacancy in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class VacancyCacheModel implements CacheModel<Vacancy>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VacancyCacheModel)) {
			return false;
		}

		VacancyCacheModel vacancyCacheModel = (VacancyCacheModel)obj;

		if (id == vacancyCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", publishedDate=");
		sb.append(publishedDate);
		sb.append(", employer=");
		sb.append(employer);
		sb.append(", text=");
		sb.append(text);
		sb.append(", salary=");
		sb.append(salary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Vacancy toEntityModel() {
		VacancyImpl vacancyImpl = new VacancyImpl();

		vacancyImpl.setId(id);

		if (publishedDate == null) {
			vacancyImpl.setPublishedDate("");
		}
		else {
			vacancyImpl.setPublishedDate(publishedDate);
		}

		if (employer == null) {
			vacancyImpl.setEmployer("");
		}
		else {
			vacancyImpl.setEmployer(employer);
		}

		if (text == null) {
			vacancyImpl.setText("");
		}
		else {
			vacancyImpl.setText(text);
		}

		if (salary == null) {
			vacancyImpl.setSalary("");
		}
		else {
			vacancyImpl.setSalary(salary);
		}

		vacancyImpl.resetOriginalValues();

		return vacancyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		publishedDate = objectInput.readUTF();
		employer = objectInput.readUTF();
		text = objectInput.readUTF();
		salary = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (publishedDate == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publishedDate);
		}

		if (employer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(employer);
		}

		if (text == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(text);
		}

		if (salary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salary);
		}
	}

	public int id;
	public String publishedDate;
	public String employer;
	public String text;
	public String salary;

}