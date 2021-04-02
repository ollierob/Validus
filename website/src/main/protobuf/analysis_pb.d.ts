// package: 
// file: analysis.proto

import * as jspb from "google-protobuf";
import * as project_pb from "./project_pb";
import * as specification_pb from "./specification_pb";

export class ProjectAnalysis extends jspb.Message {
  getId(): string;
  setId(value: string): void;

  hasProject(): boolean;
  clearProject(): void;
  getProject(): project_pb.Project | undefined;
  setProject(value?: project_pb.Project): void;

  clearSpecificationList(): void;
  getSpecificationList(): Array<SpecificationAnalysis>;
  setSpecificationList(value: Array<SpecificationAnalysis>): void;
  addSpecification(value?: SpecificationAnalysis, index?: number): SpecificationAnalysis;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): ProjectAnalysis.AsObject;
  static toObject(includeInstance: boolean, msg: ProjectAnalysis): ProjectAnalysis.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: ProjectAnalysis, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): ProjectAnalysis;
  static deserializeBinaryFromReader(message: ProjectAnalysis, reader: jspb.BinaryReader): ProjectAnalysis;
}

export namespace ProjectAnalysis {
  export type AsObject = {
    id: string,
    project?: project_pb.Project.AsObject,
    specificationList: Array<SpecificationAnalysis.AsObject>,
  }
}

export class SpecificationAnalysis extends jspb.Message {
  hasSpecification(): boolean;
  clearSpecification(): void;
  getSpecification(): specification_pb.Specification | undefined;
  setSpecification(value?: specification_pb.Specification): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): SpecificationAnalysis.AsObject;
  static toObject(includeInstance: boolean, msg: SpecificationAnalysis): SpecificationAnalysis.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: SpecificationAnalysis, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): SpecificationAnalysis;
  static deserializeBinaryFromReader(message: SpecificationAnalysis, reader: jspb.BinaryReader): SpecificationAnalysis;
}

export namespace SpecificationAnalysis {
  export type AsObject = {
    specification?: specification_pb.Specification.AsObject,
  }
}

