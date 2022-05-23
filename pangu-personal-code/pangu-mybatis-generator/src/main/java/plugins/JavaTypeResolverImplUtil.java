package plugins;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * 解决 tinyint 转为 byte问题 直接转为 Integer
 * 解决 smallint 转short问题 直接转为 Integer
 *
 * @author pengzhan.qian
 * @date 2022/5/5 16:10
 */
public class JavaTypeResolverImplUtil extends JavaTypeResolverDefaultImpl {

    public JavaTypeResolverImplUtil() {
        super();
        super.typeMap.put(-6, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
        super.typeMap.put(5, new JavaTypeResolverDefaultImpl.JdbcTypeInformation("SMALLINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
