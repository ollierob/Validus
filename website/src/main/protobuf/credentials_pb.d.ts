// package: 
// file: credentials.proto

import * as jspb from "google-protobuf";

export class UsernamePassword extends jspb.Message {
  getUsername(): string;
  setUsername(value: string): void;

  getPassword(): string;
  setPassword(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): UsernamePassword.AsObject;
  static toObject(includeInstance: boolean, msg: UsernamePassword): UsernamePassword.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: UsernamePassword, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): UsernamePassword;
  static deserializeBinaryFromReader(message: UsernamePassword, reader: jspb.BinaryReader): UsernamePassword;
}

export namespace UsernamePassword {
  export type AsObject = {
    username: string,
    password: string,
  }
}

