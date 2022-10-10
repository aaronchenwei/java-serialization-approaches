# java-serialization-approaches <!-- omit in toc -->

## 1. Frameworks

- Json:
  - https://www.json.org/
- CBOR:
  - http://cbor.io/
- Gson
- Jackson binary format backends: avro, cbor, protobuf, smile:
  - https://github.com/FasterXML/jackson-dataformats-binary
- Kryo:
  - https://github.com/EsotericSoftware/kryo
- Hessian:
  - http://hessian.caucho.com/
- MessagePack:
  - https://msgpack.org/
- Protobuf: native and protostuff
  - https://developers.google.com/protocol-buffers/
- FlatBuffers:
  - https://google.github.io/flatbuffers/
- Avro:
  - https://avro.apache.org/
- Thrift:
  - http://thrift.apache.org/
  - https://github.com/apache/thrift/blob/master/doc/specs/thrift-compact-protocol.md
- SBE:
  - https://github.com/real-logic/simple-binary-encoding


- capnproto:
  - https://capnproto.org/
  - https://dwrensha.github.io/capnproto-java/index.html

## 2. Testing

### 2.2 Serialized Size

Here is the comparison to binary size of serialized objects.

|              | Object Max<br/>(bytes) | Object Min<br/>(bytes) |
|--------------|------------------------|------------------------|
| JDK          | 205                    | 205                    |
| FST          | 90                     | 88                     |
| Kryo         | 32                     | 32                     |
| Hessian      | 189                    | 187                    |
| Hessian Lite | 189                    | 187                    |
| Message Pack | 124                    | 123                    |
