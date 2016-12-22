# temporal-objects
A library for managing objects whose state changes over time

In object oriented programming we manipulate objects by calling getters, setters, and other custom functions. 
Once an object has been changed, the old state is no longer known. This may be sufficient for some applications, 
but many applications in banking, insurance, public administration, service provisioning need to know about the
state of objects in the past. This library allows to manage objects together with their history and query the
state of the object for the present or any date in the past. 
