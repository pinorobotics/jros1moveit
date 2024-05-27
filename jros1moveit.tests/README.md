Tests for **jros1moveit** library.

Integration tests rely on [Panda robot](https://github.com/ros-planning/panda_moveit_config) and TF2 Buffer Server.

Install Panda:

``` bash
apt install ros-noetic-panda-moveit-config
```

Start TF2 Buffer Server:

``` bash
rosrun tf2_ros buffer_server
```

Use following command to run Panda:

``` bash
roslaunch panda_moveit_config demo.launch
```

If it fails [apply fix](https://answers.ros.org/question/384900/failed-to-lunch-this-command/) in /opt/ros/noetic/share/panda_moveit_config/launch/planning_context.launch

```
<param if="$(eval arg('load_robot_description') and arg('load_gripper'))" name="$(arg robot_description)" command="$(find xacro)/xacro '$(find franka_description)/robots/panda_arm.urdf.xacro' hand:=true"/>
```

In RViz subscribe to "/visualization_marker_array".
