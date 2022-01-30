package com.klassy.resttemplatepractice.modal;

import java.util.Objects;

public class Request {
    private String title;
    private String body;
    private String userId;

    public Request() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Request request = (Request) o;
        return Objects.equals(title, request.title) && Objects.equals(body, request.body) && Objects.equals(userId, request.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, userId);
    }

    @Override
    public String toString() {
        return "Request{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
