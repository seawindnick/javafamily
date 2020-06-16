package com.java.study.chapter11;

import org.apache.http.annotation.GuardedBy;

import java.util.Set;

public class SpiltLock {
    @GuardedBy("users")
    public final Set<String> users;

    @GuardedBy("queries")
    private final Set<String> queries;

    public SpiltLock(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }


    public void addUser(String user) {
        synchronized (users) {
            users.add(user);
        }

    }

    public void addQuery(String query) {
        synchronized (queries) {
            queries.add(query);
        }

    }

    public void removeUser(String user) {
        synchronized (users) {
            users.remove(user);
        }

    }


    public void removeQuery(String query) {
        synchronized (queries) {
            queries.remove(query);
        }

    }
}
