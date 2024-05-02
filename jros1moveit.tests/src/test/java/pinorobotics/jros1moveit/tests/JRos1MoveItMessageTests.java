/*
 * Copyright 2022 jrosmoveit project
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
package pinorobotics.jros1moveit.tests;

import id.jros1messages.Ros1MessageSerializationUtils;
import id.jros1messages.octomap_msgs.OctomapWithPoseMessage;
import id.jros1messages.sensor_msgs.JointStateMessage;
import id.jros1messages.std_msgs.HeaderMessage;
import id.jrosmessages.geometry_msgs.PointMessage;
import id.jrosmessages.geometry_msgs.PoseMessage;
import id.jrosmessages.geometry_msgs.QuaternionMessage;
import id.jrosmessages.std_msgs.Int32Message;
import id.jrosmessages.tests.MessageTests;
import java.util.stream.Stream;
import pinorobotics.jros1moveit.moveit_msgs.PlanningOptionsMessage;
import pinorobotics.jros1moveit.moveit_msgs.PlanningSceneMessage;
import pinorobotics.jros1moveit.moveit_msgs.PlanningSceneWorldMessage;
import pinorobotics.jros1moveit.moveit_msgs.RobotStateMessage;

/**
 * @author aeon_flux aeon_flux@eclipso.ch
 */
public class JRos1MoveItMessageTests extends MessageTests {

    public JRos1MoveItMessageTests() {
        super(new Ros1MessageSerializationUtils());
    }

    static Stream<TestCase> dataProvider() {
        return Stream.of(
                /*
                 *
                rostopic pub -r 10 helloRos "moveit_msgs/PlanningOptions" '
                planning_scene_diff:
                  name: ''
                  robot_state:
                    joint_state:
                      header:
                        seq: 0
                        stamp:
                          secs: 0
                          nsecs:         0
                        frame_id: 'test'
                      name: []
                      position: []
                      velocity: []
                      effort: []
                    multi_dof_joint_state:
                      header:
                        seq: 0
                        stamp:
                          secs: 0
                          nsecs:         0
                        frame_id: ''
                      joint_names: []
                      transforms: []
                      twist: []
                      wrench: []
                    attached_collision_objects: []
                    is_diff: False
                  robot_model_name: ''
                  fixed_frame_transforms: []
                  allowed_collision_matrix:
                    entry_names: []
                    entry_values: []
                    default_entry_names: []
                    default_entry_values: []
                  link_padding: []
                  link_scale: []
                  object_colors: []
                  world:
                    collision_objects: []
                    octomap:
                      header:
                        seq: 0
                        stamp:
                          secs: 0
                          nsecs:         0
                        frame_id: ''
                      origin:
                        position:
                          x: 1.0
                          y: 2.0
                          z: 3.0
                        orientation:
                          x: 4.0
                          y: 5.0
                          z: 6.0
                          w: 7.0
                      octomap:
                        header:
                          seq: 0
                          stamp:
                            secs: 0
                            nsecs:         0
                          frame_id: ''
                        binary: False
                        id: ''
                        resolution: 0.0
                        data: []
                  is_diff: False
                plan_only: True
                look_around: False
                look_around_attempts: 123
                max_safe_execution_cost: 0.0
                replan: False
                replan_attempts: 2
                replan_delay: 0.0
                '
                *
                */
                new TestCase(
                        "PlanningOptions",
                        new PlanningOptionsMessage()
                                .withPlanningSceneDiff(
                                        new PlanningSceneMessage()
                                                .withRobotState(
                                                        new RobotStateMessage()
                                                                .withJointState(
                                                                        new JointStateMessage()
                                                                                .withHeader(
                                                                                        new HeaderMessage()
                                                                                                .withFrameId(
                                                                                                        "test"))))
                                                .withWorld(
                                                        new PlanningSceneWorldMessage()
                                                                .withOctomap(
                                                                        new OctomapWithPoseMessage()
                                                                                .withOrigin(
                                                                                        new PoseMessage()
                                                                                                .withPosition(
                                                                                                        new PointMessage(
                                                                                                                1,
                                                                                                                2,
                                                                                                                3))
                                                                                                .withQuaternion(
                                                                                                        new QuaternionMessage(
                                                                                                                4,
                                                                                                                5,
                                                                                                                6,
                                                                                                                7))))))
                                .withPlanOnly(true)
                                .withReplanAttempts(new Int32Message().withData(2))
                                .withLookAroundAttempts(new Int32Message().withData(123))));
    }
}
