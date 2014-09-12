#_(defdeps [[io.aviso/rook "0.1.14"] [ring "1.3.1"]])

(ns org.example.allinone
  (:require
    [ring.adapter.jetty :as jetty]
    [io.aviso.rook :as rook]))

(defn show [] "Hello there!")

(defn start-server
	[port]
  (let [handler (-> (rook/namespace-handler
                     [["counter"] 'org.example.allinone])
	                   rook/wrap-with-standard-middleware)]
     (jetty/run-jetty handler {:port port :join? false})))

(start-server 8080)