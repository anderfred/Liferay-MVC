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

package com.anderfred.service.persistence.impl;

import com.anderfred.exception.NoSuchvacancySpecException;
import com.anderfred.model.impl.vacancySpecImpl;
import com.anderfred.model.impl.vacancySpecModelImpl;
import com.anderfred.model.vacancySpec;
import com.anderfred.service.persistence.impl.constants.testApiPersistenceConstants;
import com.anderfred.service.persistence.vacancySpecPersistence;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the vacancy spec service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = vacancySpecPersistence.class)
@ProviderType
public class vacancySpecPersistenceImpl
	extends BasePersistenceImpl<vacancySpec> implements vacancySpecPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>vacancySpecUtil</code> to access the vacancy spec persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		vacancySpecImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public vacancySpecPersistenceImpl() {
		setModelClass(vacancySpec.class);

		setModelImplClass(vacancySpecImpl.class);
		setModelPKClass(int.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the vacancy spec in the entity cache if it is enabled.
	 *
	 * @param vacancySpec the vacancy spec
	 */
	@Override
	public void cacheResult(vacancySpec vacancySpec) {
		entityCache.putResult(
			entityCacheEnabled, vacancySpecImpl.class,
			vacancySpec.getPrimaryKey(), vacancySpec);

		vacancySpec.resetOriginalValues();
	}

	/**
	 * Caches the vacancy specs in the entity cache if it is enabled.
	 *
	 * @param vacancySpecs the vacancy specs
	 */
	@Override
	public void cacheResult(List<vacancySpec> vacancySpecs) {
		for (vacancySpec vacancySpec : vacancySpecs) {
			if (entityCache.getResult(
					entityCacheEnabled, vacancySpecImpl.class,
					vacancySpec.getPrimaryKey()) == null) {

				cacheResult(vacancySpec);
			}
			else {
				vacancySpec.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all vacancy specs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(vacancySpecImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the vacancy spec.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(vacancySpec vacancySpec) {
		entityCache.removeResult(
			entityCacheEnabled, vacancySpecImpl.class,
			vacancySpec.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<vacancySpec> vacancySpecs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (vacancySpec vacancySpec : vacancySpecs) {
			entityCache.removeResult(
				entityCacheEnabled, vacancySpecImpl.class,
				vacancySpec.getPrimaryKey());
		}
	}

	/**
	 * Creates a new vacancy spec with the primary key. Does not add the vacancy spec to the database.
	 *
	 * @param id the primary key for the new vacancy spec
	 * @return the new vacancy spec
	 */
	@Override
	public vacancySpec create(int id) {
		vacancySpec vacancySpec = new vacancySpecImpl();

		vacancySpec.setNew(true);
		vacancySpec.setPrimaryKey(id);

		return vacancySpec;
	}

	/**
	 * Removes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public vacancySpec remove(int id) throws NoSuchvacancySpecException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the vacancy spec with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the vacancy spec
	 * @return the vacancy spec that was removed
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public vacancySpec remove(Serializable primaryKey)
		throws NoSuchvacancySpecException {

		Session session = null;

		try {
			session = openSession();

			vacancySpec vacancySpec = (vacancySpec)session.get(
				vacancySpecImpl.class, primaryKey);

			if (vacancySpec == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchvacancySpecException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(vacancySpec);
		}
		catch (NoSuchvacancySpecException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected vacancySpec removeImpl(vacancySpec vacancySpec) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(vacancySpec)) {
				vacancySpec = (vacancySpec)session.get(
					vacancySpecImpl.class, vacancySpec.getPrimaryKeyObj());
			}

			if (vacancySpec != null) {
				session.delete(vacancySpec);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (vacancySpec != null) {
			clearCache(vacancySpec);
		}

		return vacancySpec;
	}

	@Override
	public vacancySpec updateImpl(vacancySpec vacancySpec) {
		boolean isNew = vacancySpec.isNew();

		Session session = null;

		try {
			session = openSession();

			if (vacancySpec.isNew()) {
				session.save(vacancySpec);

				vacancySpec.setNew(false);
			}
			else {
				vacancySpec = (vacancySpec)session.merge(vacancySpec);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, vacancySpecImpl.class,
			vacancySpec.getPrimaryKey(), vacancySpec, false);

		vacancySpec.resetOriginalValues();

		return vacancySpec;
	}

	/**
	 * Returns the vacancy spec with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public vacancySpec findByPrimaryKey(Serializable primaryKey)
		throws NoSuchvacancySpecException {

		vacancySpec vacancySpec = fetchByPrimaryKey(primaryKey);

		if (vacancySpec == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchvacancySpecException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return vacancySpec;
	}

	/**
	 * Returns the vacancy spec with the primary key or throws a <code>NoSuchvacancySpecException</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec
	 * @throws NoSuchvacancySpecException if a vacancy spec with the primary key could not be found
	 */
	@Override
	public vacancySpec findByPrimaryKey(int id)
		throws NoSuchvacancySpecException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the vacancy spec with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the vacancy spec
	 * @return the vacancy spec, or <code>null</code> if a vacancy spec with the primary key could not be found
	 */
	@Override
	public vacancySpec fetchByPrimaryKey(int id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the vacancy specs.
	 *
	 * @return the vacancy specs
	 */
	@Override
	public List<vacancySpec> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<vacancySpec> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

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
	@Override
	public List<vacancySpec> findAll(
		int start, int end, OrderByComparator<vacancySpec> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<vacancySpec> list = (List<vacancySpec>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VACANCYSPEC);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VACANCYSPEC;

				if (pagination) {
					sql = sql.concat(vacancySpecModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<vacancySpec>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<vacancySpec>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the vacancy specs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (vacancySpec vacancySpec : findAll()) {
			remove(vacancySpec);
		}
	}

	/**
	 * Returns the number of vacancy specs.
	 *
	 * @return the number of vacancy specs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VACANCYSPEC);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VACANCYSPEC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return vacancySpecModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the vacancy spec persistence.
	 */
	@Activate
	public void activate() {
		vacancySpecModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		vacancySpecModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, vacancySpecImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, vacancySpecImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(vacancySpecImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = testApiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.anderfred.model.vacancySpec"),
			true);
	}

	@Override
	@Reference(
		target = testApiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = testApiPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VACANCYSPEC =
		"SELECT vacancySpec FROM vacancySpec vacancySpec";

	private static final String _SQL_COUNT_VACANCYSPEC =
		"SELECT COUNT(vacancySpec) FROM vacancySpec vacancySpec";

	private static final String _ORDER_BY_ENTITY_ALIAS = "vacancySpec.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No vacancySpec exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		vacancySpecPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	static {
		try {
			Class.forName(testApiPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}