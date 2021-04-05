// package: 
// file: specification.proto

import * as jspb from "google-protobuf";

export class Specification extends jspb.Message {
  getId(): string;
  setId(value: string): void;

  getDescription(): string;
  setDescription(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Specification.AsObject;
  static toObject(includeInstance: boolean, msg: Specification): Specification.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Specification, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Specification;
  static deserializeBinaryFromReader(message: Specification, reader: jspb.BinaryReader): Specification;
}

export namespace Specification {
  export type AsObject = {
    id: string,
    description: string,
  }
}

export class SpecificationList extends jspb.Message {
  clearSpecificationList(): void;
  getSpecificationList(): Array<Specification>;
  setSpecificationList(value: Array<Specification>): void;
  addSpecification(value?: Specification, index?: number): Specification;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): SpecificationList.AsObject;
  static toObject(includeInstance: boolean, msg: SpecificationList): SpecificationList.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: SpecificationList, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): SpecificationList;
  static deserializeBinaryFromReader(message: SpecificationList, reader: jspb.BinaryReader): SpecificationList;
}

export namespace SpecificationList {
  export type AsObject = {
    specificationList: Array<Specification.AsObject>,
  }
}

