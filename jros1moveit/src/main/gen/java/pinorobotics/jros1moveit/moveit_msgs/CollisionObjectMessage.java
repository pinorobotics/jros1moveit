/*
 * Copyright 2021 jrosmoveit project
 * 
 * Website: https://github.com/pinorobotics/jros1moveit
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pinorobotics.jros1moveit.moveit_msgs;

import id.jros1messages.shape_msgs.SolidPrimitiveMessage;
import id.jros1messages.std_msgs.HeaderMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.object_recognition_msgs.ObjectTypeMessage;
import id.jrosmessages.shape_msgs.MeshMessage;
import id.jrosmessages.shape_msgs.PlaneMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/** Definition for moveit_msgs/CollisionObject */
@MessageMetadata(
        name = CollisionObjectMessage.NAME,
        fields = {
            "header",
            "pose",
            "id",
            "type",
            "primitives",
            "primitive_poses",
            "meshes",
            "mesh_poses",
            "planes",
            "plane_poses",
            "subframe_names",
            "subframe_poses",
            "operation"
        },
        md5sum = "dbba710596087da521c07564160dfccb")
public class CollisionObjectMessage implements Message {

    static final String NAME = "moveit_msgs/CollisionObject";

    public enum UnknownType {
        /**
         * Adds the object to the planning scene. If the object previously existed, it is replaced.
         */
        ADD,

        /**
         * Removes the object from the environment entirely (everything that matches the specified
         * id)
         */
        REMOVE,

        /**
         * Append to an object that already exists in the planning scene. If the object does not
         * exist, it is added.
         */
        APPEND,

        /**
         * If an object already exists in the scene, new poses can be sent (the geometry arrays must
         * be left empty) if solely moving the object is desired
         */
        MOVE,
    }

    /** A header, used for interpreting the poses */
    public HeaderMessage header = new HeaderMessage();

    /**
     * The object's pose relative to the header frame. The shapes and subframe poses are defined
     * relative to this pose.
     */
    public PoseMessage pose = new PoseMessage();

    /** The id of the object (name used in MoveIt) */
    public StringMessage id = new StringMessage();

    /** The object type in a database of known objects */
    public ObjectTypeMessage type = new ObjectTypeMessage();

    /**
     * The collision geometries associated with the object. Their poses are with respect to the
     * object's pose Solid geometric primitives
     */
    public SolidPrimitiveMessage[] primitives = new SolidPrimitiveMessage[0];

    public PoseMessage[] primitive_poses = new PoseMessage[0];

    /** Meshes */
    public MeshMessage[] meshes = new MeshMessage[0];

    public PoseMessage[] mesh_poses = new PoseMessage[0];

    /**
     * Bounding planes (equation is specified, but the plane can be oriented using an additional
     * pose)
     */
    public PlaneMessage[] planes = new PlaneMessage[0];

    public PoseMessage[] plane_poses = new PoseMessage[0];

    /**
     * Named subframes on the object. Use these to define points of interest on the object that you
     * want to plan with (e.g. "tip", "spout", "handle"). The id of the object will be prepended to
     * the subframe. If an object with the id "screwdriver" and a subframe "tip" is in the scene,
     * you can use the frame "screwdriver/tip" for planning. The length of the subframe_names and
     * subframe_poses has to be identical.
     */
    public StringMessage[] subframe_names = new StringMessage[0];

    public PoseMessage[] subframe_poses = new PoseMessage[0];

    /** Operation to be performed */
    public byte operation;

    public CollisionObjectMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public CollisionObjectMessage withPose(PoseMessage pose) {
        this.pose = pose;
        return this;
    }

    public CollisionObjectMessage withId(StringMessage id) {
        this.id = id;
        return this;
    }

    public CollisionObjectMessage withType(ObjectTypeMessage type) {
        this.type = type;
        return this;
    }

    public CollisionObjectMessage withPrimitives(SolidPrimitiveMessage... primitives) {
        this.primitives = primitives;
        return this;
    }

    public CollisionObjectMessage withPrimitivePoses(PoseMessage... primitive_poses) {
        this.primitive_poses = primitive_poses;
        return this;
    }

    public CollisionObjectMessage withMeshes(MeshMessage... meshes) {
        this.meshes = meshes;
        return this;
    }

    public CollisionObjectMessage withMeshPoses(PoseMessage... mesh_poses) {
        this.mesh_poses = mesh_poses;
        return this;
    }

    public CollisionObjectMessage withPlanes(PlaneMessage... planes) {
        this.planes = planes;
        return this;
    }

    public CollisionObjectMessage withPlanePoses(PoseMessage... plane_poses) {
        this.plane_poses = plane_poses;
        return this;
    }

    public CollisionObjectMessage withSubframeNames(StringMessage... subframe_names) {
        this.subframe_names = subframe_names;
        return this;
    }

    public CollisionObjectMessage withSubframePoses(PoseMessage... subframe_poses) {
        this.subframe_poses = subframe_poses;
        return this;
    }

    public CollisionObjectMessage withOperation(byte operation) {
        this.operation = operation;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                pose,
                id,
                type,
                Arrays.hashCode(primitives),
                Arrays.hashCode(primitive_poses),
                Arrays.hashCode(meshes),
                Arrays.hashCode(mesh_poses),
                Arrays.hashCode(planes),
                Arrays.hashCode(plane_poses),
                Arrays.hashCode(subframe_names),
                Arrays.hashCode(subframe_poses),
                operation);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (CollisionObjectMessage) obj;
        return Objects.equals(header, other.header)
                && Objects.equals(pose, other.pose)
                && Objects.equals(id, other.id)
                && Objects.equals(type, other.type)
                && Arrays.equals(primitives, other.primitives)
                && Arrays.equals(primitive_poses, other.primitive_poses)
                && Arrays.equals(meshes, other.meshes)
                && Arrays.equals(mesh_poses, other.mesh_poses)
                && Arrays.equals(planes, other.planes)
                && Arrays.equals(plane_poses, other.plane_poses)
                && Arrays.equals(subframe_names, other.subframe_names)
                && Arrays.equals(subframe_poses, other.subframe_poses)
                && operation == other.operation;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "pose", pose,
                "id", id,
                "type", type,
                "primitives", primitives,
                "primitive_poses", primitive_poses,
                "meshes", meshes,
                "mesh_poses", mesh_poses,
                "planes", planes,
                "plane_poses", plane_poses,
                "subframe_names", subframe_names,
                "subframe_poses", subframe_poses,
                "operation", operation);
    }
}
