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
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.shape_msgs.MeshMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for moveit_msgs/BoundingVolume
 *
 * <p>Define a volume in 3D
 */
@MessageMetadata(
        name = BoundingVolumeMessage.NAME,
        fields = {"primitives", "primitive_poses", "meshes", "mesh_poses"},
        md5sum = "22db94010f39e9198032cb4a1aeda26e")
public class BoundingVolumeMessage implements Message {

    static final String NAME = "moveit_msgs/BoundingVolume";

    /** A set of solid geometric primitives that make up the volume to define (as a union) */
    public SolidPrimitiveMessage[] primitives = new SolidPrimitiveMessage[0];

    /** The poses at which the primitives are located */
    public PoseMessage[] primitive_poses = new PoseMessage[0];

    /**
     * In addition to primitives, meshes can be specified to add to the bounding volume (again, as
     * union)
     */
    public MeshMessage[] meshes = new MeshMessage[0];

    /** The poses at which the meshes are located */
    public PoseMessage[] mesh_poses = new PoseMessage[0];

    public BoundingVolumeMessage withPrimitives(SolidPrimitiveMessage... primitives) {
        this.primitives = primitives;
        return this;
    }

    public BoundingVolumeMessage withPrimitivePoses(PoseMessage... primitive_poses) {
        this.primitive_poses = primitive_poses;
        return this;
    }

    public BoundingVolumeMessage withMeshes(MeshMessage... meshes) {
        this.meshes = meshes;
        return this;
    }

    public BoundingVolumeMessage withMeshPoses(PoseMessage... mesh_poses) {
        this.mesh_poses = mesh_poses;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                Arrays.hashCode(primitives),
                Arrays.hashCode(primitive_poses),
                Arrays.hashCode(meshes),
                Arrays.hashCode(mesh_poses));
    }

    @Override
    public boolean equals(Object obj) {
        var other = (BoundingVolumeMessage) obj;
        return Arrays.equals(primitives, other.primitives)
                && Arrays.equals(primitive_poses, other.primitive_poses)
                && Arrays.equals(meshes, other.meshes)
                && Arrays.equals(mesh_poses, other.mesh_poses);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "primitives", primitives,
                "primitive_poses", primitive_poses,
                "meshes", meshes,
                "mesh_poses", mesh_poses);
    }
}
