/*
 * JBoss, Home of Professional Open Source
 * Copyright 2009, JBoss Inc., and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.vfs.util.automount;

/**
 * Abstract MountOwner used to wrap a real object as an owner.
 *
 * @param <T> the type of the actual owner
 * @author <a href="jbailey@redhat.com">John Bailey</a>
 */
public abstract class AbstractMountOwner<T> implements MountOwner {
    private final T owner;

    /**
     * Construct with an object.
     *
     * @param owner the actual owner
     */
    protected AbstractMountOwner(T owner) {
        this.owner = owner;
    }

    /**
     * Get the owner object
     *
     * @return the actual owner
     */
    protected T getOwner() {
        return owner;
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AbstractMountOwner)) { return false; }
        return getOwner().equals(AbstractMountOwner.class.cast(other).getOwner());
    }

    @Override
    public int hashCode() {
        return getOwner().hashCode();
    }
}
