package com.ccc.mybatis.builder;

import com.ccc.mybatis.session.Configuration;

/**
 * @author chenchicheng
 * @date 2024/4/19
 */
public abstract class BaseBuilder {

    protected final Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

}
