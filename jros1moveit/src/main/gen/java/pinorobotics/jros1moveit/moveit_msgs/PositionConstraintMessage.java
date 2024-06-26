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

import id.jros1messages.std_msgs.HeaderMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.geometry_msgs.Vector3Message;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for moveit_msgs/PositionConstraint
 *
 * <p>This message contains the definition of a position constraint.
 */
@MessageMetadata(
        name = PositionConstraintMessage.NAME,
        fields = {"header", "link_name", "target_point_offset", "constraint_region", "weight"},
        md5sum = "c83edf208d87d3aa3169f47775a58e6a")
public class PositionConstraintMessage implements Message {

    static final String NAME = "moveit_msgs/PositionConstraint";

    public HeaderMessage header = new HeaderMessage();

    /** The robot link this constraint refers to */
    public StringMessage link_name = new StringMessage();

    /** The offset (in the link frame) for the target point on the link we are planning for */
    public Vector3Message target_point_offset = new Vector3Message();

    /** The volume this constraint refers to */
    public BoundingVolumeMessage constraint_region = new BoundingVolumeMessage();

    /**
     * A weighting factor for this constraint (denotes relative importance to other constraints.
     * Closer to zero means less important)
     */
    public double weight;

    public PositionConstraintMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public PositionConstraintMessage withLinkName(StringMessage link_name) {
        this.link_name = link_name;
        return this;
    }

    public PositionConstraintMessage withTargetPointOffset(Vector3Message target_point_offset) {
        this.target_point_offset = target_point_offset;
        return this;
    }

    public PositionConstraintMessage withConstraintRegion(BoundingVolumeMessage constraint_region) {
        this.constraint_region = constraint_region;
        return this;
    }

    public PositionConstraintMessage withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(header, link_name, target_point_offset, constraint_region, weight);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (PositionConstraintMessage) obj;
        return Objects.equals(header, other.header)
                && Objects.equals(link_name, other.link_name)
                && Objects.equals(target_point_offset, other.target_point_offset)
                && Objects.equals(constraint_region, other.constraint_region)
                && weight == other.weight;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "link_name", link_name,
                "target_point_offset", target_point_offset,
                "constraint_region", constraint_region,
                "weight", weight);
    }
}
