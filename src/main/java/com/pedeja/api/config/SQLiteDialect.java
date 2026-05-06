package com.pedeja.api.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    @Override
    public IdentityColumnSupportImpl getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl();
    }
}
