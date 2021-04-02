// package: maven
// file: project_analysis.proto

import * as jspb from "google-protobuf";

export class A extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): A.AsObject;
  static toObject(includeInstance: boolean, msg: A): A.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: A, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): A;
  static deserializeBinaryFromReader(message: A, reader: jspb.BinaryReader): A;
}

export namespace A {
  export type AsObject = {
  }
}

