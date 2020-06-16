package com.java.study.chapter11;

import org.apache.http.annotation.GuardedBy;

import java.util.Set;

public class ServerStatus {
    @GuardedBy("this")
    public final Set<String> users;

    @GuardedBy("this")
    private final Set<String> queries;

    public ServerStatus(Set<String> users, Set<String> queries) {
        this.users = users;
        this.queries = queries;
    }


    public synchronized void addUser(String user) {
        users.add(user);
    }

    public synchronized void addQuery(String query) {
        queries.add(query);
    }

    public synchronized void removeUser(String user) {
        users.remove(user);
    }


    public synchronized void removeQuery(String query) {
        queries.remove(query);
    }
}
