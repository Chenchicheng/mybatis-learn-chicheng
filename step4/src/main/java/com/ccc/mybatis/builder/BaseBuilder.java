package com.ccc.mybatis.builder;

import com.ccc.mybatis.session.Configuration;
import com.ccc.mybatis.type.TypeAliasRegistry;

/**
 * @author chenchicheng
 * @date 2024/4/19
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry = configuration.getTypeAliasRegistry();
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
