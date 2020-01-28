package io.crnk.core.queryspec.mapper;

import io.crnk.core.engine.information.resource.ResourceInformation;
import io.crnk.core.engine.query.QueryContext;
import io.crnk.core.queryspec.QuerySpec;

import java.util.Collection;
import java.util.Set;

/**
 * Allows the contruction of an url out of a QuerySpec
 */
public interface UrlBuilder {

	/**
	 * Parameter propagation allows to pass along non-JSON-API parameters to a repository and include it in all the computed links
	 * (paging, self, related). Use case is, for example, to allow passing security-related parameters in the URL rather than
	 * request headers, improving usability for developers (like the CSRF token, but be careful here...).
	 *
	 * @param name of parameter
	 */
	void addPropagatedParameter(String name);

	/**
	 * {@link #addPropagatedParameter(String)}
	 */
	Set<String> getPropagatedParameters();

	String buildUrl(QueryContext queryContext, ResourceInformation resourceInformation);

	String buildUrl(QueryContext queryContext, ResourceInformation resourceInformation, Object id, QuerySpec querySpec);

	String buildUrl(QueryContext queryContext, ResourceInformation resourceInformation, Object id, QuerySpec querySpec, String relationshipName);

	String buildUrl(QueryContext queryContext, ResourceInformation resourceInformation, Object id, QuerySpec querySpec, String relationshipName, boolean selfLink);
}
