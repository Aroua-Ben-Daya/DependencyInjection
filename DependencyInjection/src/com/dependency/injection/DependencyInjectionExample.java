package com.dependency.injection;

public class DependencyInjectionExample {
    // Service interface
    interface Service {
        String getInfo();
    }

    // ServiceB implementation
    static class ServiceB implements Service {
        @Override
        public String getInfo() {
            return "ServiceB's Info";
        }
    }

    // ServiceC implementation
    static class ServiceC implements Service {
        @Override
        public String getInfo() {
            return "ServiceC's Info";
        }
    }

    // Client interface
    interface Client {
        void doSomething();
    }

    // ClientA implementation with constructor and setter injection
    static class ClientA implements Client {
        private Service service;

        public ClientA(Service service) {
            this.service = service;
        }

        @Override
        public void doSomething() {
            String info = service.getInfo();
            System.out.println(info);
        }

        public void setService(Service service) {
            this.service = service;
        }
    }

    public static void main(String[] args) {
        // Creating a ServiceB instance
        ServiceB serviceB = new ServiceB();

        // Creating ClientA instance with ServiceB injected
        ClientA clientA = new ClientA(serviceB);
        clientA.doSomething();

        // Changing the service implementation to ServiceC using setter injection
        if (clientA instanceof ClientA) {
            ((ClientA) clientA).setService(new ServiceC());
        }
        clientA.doSomething();
    }
}
