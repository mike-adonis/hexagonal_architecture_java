Hexagonal Architecture:

Overview

This article will evaluate and illustrate the implementation of a Hexagonal architecture also known as the Ports and Adapter pattern using the spring boot framework.

In this article we will refer to our business logic,rules and models as the core application.

The Hexagonal architecture was invented by Alistar Cockburn as a solution to frequently occurring structural problems in object oriented applications, this pattern was invented for the following benefits: Easy and quick maintainability,Technical depth reduction, separation of concerns and business logic preservation. These features are achieved by splitting various make-up components into detachable ports and adapters.

The Hexagonal tag does not necessarily mean it is a 6 sided architecture, it’s more indicative of a multi port/adapter situation.

It’s also important to note that the resulting project structure can be implemented as you see fit; however we have provided the general guidelines which we will implement in this tutorial.

At the heart of a hexagonal architecture is the core application so we will start our implementations here.

Everything else is a slave to the core application, so your input and output ports (interfaces)  should be defined based on the requirements of the core application and not the other way around, This makes sense because any changes to the core application, model or logic is usually indicative of a new business requirement and as such you don’t want this changing every time you make an infrastructural change or add some new layer.

The application connects to every data source using adapters : whether we’re making an input via http to the server or storing outputs to a database we should use detachable adapters.

We’ll be building a wallet based application for buying raw food items and we’ll call it kitchen-assistant.

First we create business models in the “domain” package a User,Wallet,Address and Orders 
Next we'll create the "application" package with a subpackages port.in and port.out



