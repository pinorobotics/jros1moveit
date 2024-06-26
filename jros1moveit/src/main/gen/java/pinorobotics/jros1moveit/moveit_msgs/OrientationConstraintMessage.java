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
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.std_msgs.StringMessage;
import id.xfunction.XJson;
import java.util.Objects;

/**
 * Definition for moveit_msgs/OrientationConstraint
 *
 * <p>This message contains the definition of an orientation constraint.
 */
@MessageMetadata(
        name = OrientationConstraintMessage.NAME,
        fields = {
            "header",
            "orientation",
            "link_name",
            "absolute_x_axis_tolerance",
            "absolute_y_axis_tolerance",
            "absolute_z_axis_tolerance",
            "parameterization",
            "weight"
        },
        md5sum = "183479d9281e5b4f23dc584f711d8a64")
public class OrientationConstraintMessage implements Message {

    static final String NAME = "moveit_msgs/OrientationConstraint";

    public enum UnknownType {
        /**
         * The different options for the orientation error parameterization - Intrinsic xyz Euler
         * angles (default value)
         */
        XYZ_EULER_ANGLES,

        /**
         * - A rotation vector. This is similar to the angle-axis representation, but the magnitude
         * of the vector represents the rotation angle.
         */
        ROTATION_VECTOR,
    }

    public HeaderMessage header = new HeaderMessage();

    /** The desired orientation of the robot link specified as a quaternion */
    public QuaternionMessage orientation = new QuaternionMessage();

    /** The robot link this constraint refers to */
    public StringMessage link_name = new StringMessage();

    /** Tolerance on the three vector components of the orientation error (optional) */
    public double absolute_x_axis_tolerance;

    public double absolute_y_axis_tolerance;

    public double absolute_z_axis_tolerance;

    /**
     * Defines how the orientation error is calculated The error is compared to the tolerance
     * defined above
     */
    public byte parameterization;

    /**
     * A weighting factor for this constraint (denotes relative importance to other constraints.
     * Closer to zero means less important)
     */
    public double weight;

    public OrientationConstraintMessage withHeader(HeaderMessage header) {
        this.header = header;
        return this;
    }

    public OrientationConstraintMessage withOrientation(QuaternionMessage orientation) {
        this.orientation = orientation;
        return this;
    }

    public OrientationConstraintMessage withLinkName(StringMessage link_name) {
        this.link_name = link_name;
        return this;
    }

    public OrientationConstraintMessage withAbsoluteXAxisTolerance(
            double absolute_x_axis_tolerance) {
        this.absolute_x_axis_tolerance = absolute_x_axis_tolerance;
        return this;
    }

    public OrientationConstraintMessage withAbsoluteYAxisTolerance(
            double absolute_y_axis_tolerance) {
        this.absolute_y_axis_tolerance = absolute_y_axis_tolerance;
        return this;
    }

    public OrientationConstraintMessage withAbsoluteZAxisTolerance(
            double absolute_z_axis_tolerance) {
        this.absolute_z_axis_tolerance = absolute_z_axis_tolerance;
        return this;
    }

    public OrientationConstraintMessage withParameterization(byte parameterization) {
        this.parameterization = parameterization;
        return this;
    }

    public OrientationConstraintMessage withWeight(double weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                header,
                orientation,
                link_name,
                absolute_x_axis_tolerance,
                absolute_y_axis_tolerance,
                absolute_z_axis_tolerance,
                parameterization,
                weight);
    }

    @Override
    public boolean equals(Object obj) {
        var other = (OrientationConstraintMessage) obj;
        return Objects.equals(header, other.header)
                && Objects.equals(orientation, other.orientation)
                && Objects.equals(link_name, other.link_name)
                && absolute_x_axis_tolerance == other.absolute_x_axis_tolerance
                && absolute_y_axis_tolerance == other.absolute_y_axis_tolerance
                && absolute_z_axis_tolerance == other.absolute_z_axis_tolerance
                && parameterization == other.parameterization
                && weight == other.weight;
    }

    @Override
    public String toString() {
        return XJson.asString(
                "header", header,
                "orientation", orientation,
                "link_name", link_name,
                "absolute_x_axis_tolerance", absolute_x_axis_tolerance,
                "absolute_y_axis_tolerance", absolute_y_axis_tolerance,
                "absolute_z_axis_tolerance", absolute_z_axis_tolerance,
                "parameterization", parameterization,
                "weight", weight);
    }
}
