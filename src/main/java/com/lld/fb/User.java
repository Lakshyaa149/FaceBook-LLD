package com.lld.fb;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class User {
    private Integer userId;
    private Set<Integer> followed;
    private Map<Integer, Post> postMap;
    private Post head;
    private Post tail;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Set<Integer> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<Integer> followed) {
        this.followed = followed;
    }

    public Map<Integer, Post> getPostMap() {
        return postMap;
    }

    public void setPostMap(Map<Integer, Post> postMap) {
        this.postMap = postMap;
    }

    public Post getHead() {
        return head;
    }

    public void setHead(Post head) {
        this.head = head;
    }

    public Post getTail() {
        return tail;
    }

    public void setTail(Post tail) {
        this.tail = tail;
    }

    public User(Integer userId) {
        this.userId = userId;
        this.followed = new HashSet<>();
        follow(userId);
        this.postMap = new HashMap<>();
        this.head = new Post(-1);
        this.tail = new Post(-1);
        this.head.setPrev(null);
        this.tail.setNext(null);

        this.head.setNext(tail);
        this.tail.setPrev(head);
    }

    public void follow(Integer userId) {
        followed.add(userId);
    }

    public void unfollow(Integer userId) {
        followed.remove(userId);
    }
    public void createPost(Integer postId) {
        Post post = new Post(postId);
        postMap.put(postId, post);
        Post next = head.getNext();
        head.setNext(post);
        next.setPrev(post);

        post.setPrev(head);
        post.setNext(next);
    }

    public void deletePost(Integer postId) {
        Post post = postMap.get(postId);
        postMap.remove(postId);
        Post prev = post.getPrev();
        Post next = post.getNext();

        prev.setNext(next);
        next.setPrev(prev);
    }
}