package org.acme.proxy;

import io.quarkus.builder.item.SimpleBuildItem;

public final class ProxyBuildItem extends SimpleBuildItem {
    private final String className;
    private final byte[] bytecode;

    public ProxyBuildItem(String className, byte[] bytecode) {
        this.className = className;
        this.bytecode = bytecode;
    }

    public String getClassName() {
        return className;
    }

    public byte[] getBytecode() {
        return bytecode;
    }
}
