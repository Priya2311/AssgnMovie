/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.imdb.vo;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.imdb.vo.Status.ERROR;
import static com.imdb.vo.Status.LOADING;
import static com.imdb.vo.Status.SUCCESS;


/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
public class Resource<T> {
    @NonNull
    public final Status status;

    @Nullable
    public final String message;

    @Nullable
    public final boolean Success;

    @Nullable
    public final T data;


    public final int code;

    public Resource(@NonNull Status Status, @Nullable T data, @Nullable String message, int code, boolean success) {
        this.status = Status;
        this.data = data;
        this.message = message;
        this.code = code;
        this.Success = success;
    }

    public static <T> Resource<T> success(@Nullable T data, int code) {
        return new Resource<>(SUCCESS, data, null, code, true);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data, int code) {
        return new Resource<>(ERROR, data, msg, code, false);
    }

    public static <T> Resource<T> loading(@Nullable T data, int code) {
        return new Resource<>(LOADING, data, null, code, false);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Resource<?> resource = (Resource<?>) o;


        if (status != resource.status) {
            return false;
        }
        if (message != null ? !message.equals(resource.message) : resource.message != null) {
            return false;
        }
        return data != null ? data.equals(resource.data) : resource.data == null;
    }

    @Override
    public int hashCode() {
        int result = status.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    /*  @Override
      public String toString() {
          return "Resource{" +
                  "status=" + status +
                  ", message='" + message + '\'' +
                  ", data=" + data +
                  '}';
      }*/
    @Override
    public String toString() {
        return "Resource{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
