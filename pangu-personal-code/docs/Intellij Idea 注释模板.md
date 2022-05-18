~~~java
idea->setting->Editor->File and Code Templates->class,Interface等下的注释模版:

/**
 *
 * @author pengzhan.qian
 * @since 1.0.0
 */
/**
 * 
 * @author pengzhan.qian
 * @date ${DATE} ${TIME}
 */


        自定义live template
        上面是*tab
        下面的表达式为：
        *
        *$description$$params$
        *@return $return$
        *@author pengzhan.qian
        *@since 1.0.0
        */

        return
        groovyScript("if(\"${_1}\".length() == 2) {return '';} else {def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList();for(i = 0; i < params.size(); i++) {if(params[i]=='null'){return;}else{result+='\\n' + ' * @param ' + params[i] + '		'}}; return result;}",methodParameters());

        params
        groovyScript("def result=''; def params=\"${_1}\".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split('<').toList(); for(i = 0; i < params.size(); i++) {if(i!=0){result+='<';};  def p1=params[i].split(',').toList();  for(i2 = 0; i2 < p1.size(); i2++) { def p2=p1[i2].split('\\\\.').toList();  result+=p2[p2.size()-1]; if(i2!=p1.size()-1){result+=','}  } ;  };  return result",methodReturnType())
~~~

