(def lwjgl-modules ["lwjgl"
                    "lwjgl-glfw"
                    "lwjgl-openal"
                    "lwjgl-opengl"
                    "lwjgl-opengles"
                    "lwjgl-par"
                    "lwjgl-stb"])

(def lwjgl-platforms ["natives-linux" "natives-windows"])

(def lwjgl-deps (for [m lwjgl-modules
                      :let [prefix [(symbol "org.lwjgl" m) "3.3.3"]]
                      x (->>
                         lwjgl-platforms
                         (map #(into prefix [:classifier % :native-prefix ""]))
                         (cons prefix))]
                  x))

(def deps (into lwjgl-deps
                '[[com.creedvi.utils/gltfj "0.0.1"]
                  [fr.delthas/javamp3 "1.0.1"]
                  [org.jetbrains/annotations "24.1.0"]]))

(defproject com.raylib/raylib-j "0.5.2"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Zlib License"
            :url "https://github.com/CreedVI/Raylib-J/blob/main/LICENSE"}
  :dependencies ~deps
  :java-source-paths ["src/main/java"])
