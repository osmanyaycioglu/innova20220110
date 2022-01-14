package com.training.spring.rabbit;


public class Message {

    private String message;
    private String destination;

    protected final String getMessage() {
        return this.message;
    }

    protected final void setMessage(final String messageParam) {
        this.message = messageParam;
    }

    protected final String getDestination() {
        return this.destination;
    }

    protected final void setDestination(final String destinationParam) {
        this.destination = destinationParam;
    }

    @Override
    public String toString() {
        return "Message [message=" + this.message + ", destination=" + this.destination + "]";
    }


}
