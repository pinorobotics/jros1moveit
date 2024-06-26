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

import id.jros1messages.geometry_msgs.PoseStampedMessage;
import id.jrosmessages.Message;
import id.jrosmessages.MessageMetadata;
import id.jrosmessages.primitives.Duration;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Arrays;
import java.util.Objects;

/**
 * Definition for moveit_msgs/PositionIKRequest
 *
 * <p>A Position IK request message
 */
@MessageMetadata(
        name = PositionIKRequestMessage.NAME,
        fields = {
            "group_name",
            "robot_state",
            "constraints",
            "avoid_collisions",
            "ik_link_name",
            "pose_stamped",
            "ik_link_names",
            "pose_stamped_vector",
            "timeout"
        },
        md5sum = "cb7c3615ee4d29d023dfdc5950af0504")
public class PositionIKRequestMessage implements Message {

    static final String NAME = "moveit_msgs/PositionIKRequest";

    /**
     * The name of the group which will be used to compute IK e.g. "right_arm", or "arms" - see IK
     * specification for multiple-groups below Information from the SRDF will be used to
     * automatically determine which link to solve IK for, unless ik_link_name is also specified
     */
    public StringMessage group_name = new StringMessage();

    /**
     * A RobotState consisting of hint/seed positions for the IK computation and positions for all
     * the other joints in the robot. Additional state information provided here is used to specify
     * starting positions for other joints/links on the robot. This state MUST contain state for all
     * joints to be used by the IK solver to compute IK. The list of joints that the IK solver deals
     * with can be found using the SRDF for the corresponding group
     */
    public RobotStateMessage robot_state = new RobotStateMessage();

    /** A set of constraints that the IK must obey; by default, this set of constraints is empty */
    public ConstraintsMessage constraints = new ConstraintsMessage();

    /** Find an IK solution that avoids collisions. By default, this is false */
    public boolean avoid_collisions;

    /**
     * (OPTIONAL) The name of the link for which we are computing IK If not specified, the link name
     * will be inferred from a combination of the group name and the SRDF. If any values are
     * specified for ik_link_names, this value is ignored
     */
    public StringMessage ik_link_name = new StringMessage();

    /**
     * The stamped pose of the link, when the IK solver computes the joint values for all the joints
     * in a group. This value is ignored if pose_stamped_vector has any elements specified.
     */
    public PoseStampedMessage pose_stamped = new PoseStampedMessage();

    /**
     * Multi-group parameters (OPTIONAL) The names of the links for which we are computing IK If not
     * specified, the link name will be inferred from a combination of the group name and the SRDF
     */
    public StringMessage[] ik_link_names = new StringMessage[0];

    /**
     * (OPTIONAL) The (stamped) poses of the links we are computing IK for (when a group has more
     * than one end effector) e.g. The "arms" group might consist of both the "right_arm" and the
     * "left_arm" The order of the groups referred to is the same as the order setup in the SRDF
     */
    public PoseStampedMessage[] pose_stamped_vector = new PoseStampedMessage[0];

    /** Maximum allowed time for IK calculation */
    public Duration timeout = new Duration();

    public PositionIKRequestMessage withGroupName(StringMessage group_name) {
        this.group_name = group_name;
        return this;
    }

    public PositionIKRequestMessage withRobotState(RobotStateMessage robot_state) {
        this.robot_state = robot_state;
        return this;
    }

    public PositionIKRequestMessage withConstraints(ConstraintsMessage constraints) {
        this.constraints = constraints;
        return this;
    }

    public PositionIKRequestMessage withAvoidCollisions(boolean avoid_collisions) {
        this.avoid_collisions = avoid_collisions;
        return this;
    }

    public PositionIKRequestMessage withIkLinkName(StringMessage ik_link_name) {
        this.ik_link_name = ik_link_name;
        return this;
    }

    public PositionIKRequestMessage withPoseStamped(PoseStampedMessage pose_stamped) {
        this.pose_stamped = pose_stamped;
        return this;
    }

    public PositionIKRequestMessage withIkLinkNames(StringMessage... ik_link_names) {
        this.ik_link_names = ik_link_names;
        return this;
    }

    public PositionIKRequestMessage withPoseStampedVector(
            PoseStampedMessage... pose_stamped_vector) {
        this.pose_stamped_vector = pose_stamped_vector;
        return this;
    }

    public PositionIKRequestMessage withTimeout(Duration timeout) {
        this.timeout = timeout;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                group_name,
                robot_state,
                constraints,
                avoid_collisions,
                ik_link_name,
                pose_stamped,
                Arrays.hashCode(ik_link_names),
                Arrays.hashCode(pose_stamped_vector),
                timeout);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (PositionIKRequestMessage) obj;
        return Objects.equals(group_name, other.group_name)
                && Objects.equals(robot_state, other.robot_state)
                && Objects.equals(constraints, other.constraints)
                && avoid_collisions == other.avoid_collisions
                && Objects.equals(ik_link_name, other.ik_link_name)
                && Objects.equals(pose_stamped, other.pose_stamped)
                && Arrays.equals(ik_link_names, other.ik_link_names)
                && Arrays.equals(pose_stamped_vector, other.pose_stamped_vector)
                && Objects.equals(timeout, other.timeout);
    }

    @Override
    public String toString() {
        return XJson.asString(
                "group_name", group_name,
                "robot_state", robot_state,
                "constraints", constraints,
                "avoid_collisions", avoid_collisions,
                "ik_link_name", ik_link_name,
                "pose_stamped", pose_stamped,
                "ik_link_names", ik_link_names,
                "pose_stamped_vector", pose_stamped_vector,
                "timeout", timeout);
    }
}
