# java-serialization-approaches

## Frameworks

- Protobuf: native and protostuff
  - https://developers.google.com/protocol-buffers/
- FlatBuffers:
  - https://google.github.io/flatbuffers/
- Json:
  - https://www.json.org/
- Kryo:
  - https://github.com/EsotericSoftware/kryo
- Hessian:
  - http://hessian.caucho.com/
- Avro:
  - https://avro.apache.org/
- Kafka Schema
- CBOR:
  - http://cbor.io/
- MessagePack:
  - https://msgpack.org/
- Thrift:
  - http://thrift.apache.org/
  - https://github.com/apache/thrift/blob/master/doc/specs/thrift-compact-protocol.md
- SBE:
  - https://github.com/real-logic/simple-binary-encoding
- Jackson binary format backends: avro, cbor, protobuf, smile:
  - https://github.com/FasterXML/jackson-dataformats-binary
- FlatBuffers:
  - https://google.github.io/flatbuffers/
- capnproto:
  - https://capnproto.org/
  - https://dwrensha.github.io/capnproto-java/index.html

## Serialized Size

Here is the comparison to binary size of serialized objects.

|              | Object Max<br/>(bytes) | Object Min<br/>(bytes) |
|--------------|------------------------|------------------------|
| JDK          | 205                    | 205                    |
| FST          | 90                     | 88                     |
| Kryo         | 32                     | 32                     |
| Hessian      | 189                    | 187                    |
| Hessian Lite | 189                    | 187                    |
| Message Pack | 124                    | 123                    |
