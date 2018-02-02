package com.example.kevin.injectorview.javabean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevin on 2018/2/2.
 * https://github.com/yinkaiwen
 */

public class InjectorInfo {

    public String pkName;
    public String className;
    public Map<String, Integer> values = new HashMap<>();

    public InjectorInfo(String pkName, String className) {
        this.pkName = pkName;
        this.className = className;
    }

    public InjectorInfo() {
    }

    @Override
    public int hashCode() {
        int rs = 17;
        int p = 37;
        rs = rs * p + pkName.hashCode();
        rs = rs * p + className.hashCode();
        return rs;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(obj instanceof InjectorInfo){
            InjectorInfo info = (InjectorInfo) obj;
            if(info.className.equals(className) && info.pkName.equals(pkName))
                return true;
        }
        return false;
    }
}
