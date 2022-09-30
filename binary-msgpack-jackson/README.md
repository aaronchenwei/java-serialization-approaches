MessagePack for Java
=== 

[MessagePack](http://msgpack.org) is a binary serialization format. If you need a fast and compact alternative of JSON, MessagePack is your friend. For example, a small integer can be encoded in a single byte, and short strings only need a single byte prefix + the original byte array. MessagePack implementation is already available in various languages (See also the list in http://msgpack.org) and works as a universal data format.

* Message Pack specification: <https://github.com/msgpack/msgpack/blob/master/spec.md>

MessagePack v7 (or later) is a faster implementation of the previous version [v06](https://github.com/msgpack/msgpack-java/tree/v06), and
supports all of the message pack types, including [extension format](https://github.com/msgpack/msgpack/blob/master/spec.md#formats-ext).

[JavaDoc is available at javadoc.io](https://www.javadoc.io/doc/org.msgpack/msgpack-core).
