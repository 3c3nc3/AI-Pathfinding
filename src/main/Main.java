package main;

import app.App;

class Main {
    public static void main(String args[]) {
        Thread app = new Thread(new App());
        app.start();
    }
}