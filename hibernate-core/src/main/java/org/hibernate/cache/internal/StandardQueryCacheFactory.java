/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2008-2011, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.cache.internal;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.spi.QueryCache;
import org.hibernate.cache.spi.QueryCacheFactory;
import org.hibernate.cache.spi.UpdateTimestampsCache;

/**
 * Standard Hibernate implementation of the QueryCacheFactory interface.  Returns instances of
 * {@link StandardQueryCache}.
 */
public class StandardQueryCacheFactory implements QueryCacheFactory {
	/**
	 * Singleton access
	 */
	public static final StandardQueryCacheFactory INSTANCE = new StandardQueryCacheFactory();

	@Override
	public QueryCache getQueryCache(
			final String regionName,
			final UpdateTimestampsCache updateTimestampsCache,
			final SessionFactoryOptions settings,
			final Properties props) throws HibernateException {
		return new StandardQueryCache(settings, props, updateTimestampsCache, regionName);
	}
}
