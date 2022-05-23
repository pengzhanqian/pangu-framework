package plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;

import java.util.List;

/**
 * 给mapper接口添加@Mapper@Repository注解
 *
 * @author pengzhan.qian
 * @date 2022/5/6 10:58
 */
public class MyMapperAnnotationPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, IntrospectedTable introspectedTable) {

        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
            interfaze.addAnnotation("@Mapper");

            interfaze.addImportedType(
                    new FullyQualifiedJavaType("org.springframework.stereotype.Repository"));
            interfaze.addAnnotation("@Repository");
        }
        return true;
    }
}
