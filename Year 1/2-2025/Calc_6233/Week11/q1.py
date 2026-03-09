import numpy as np
from scipy.integrate import odeint
import matplotlib.pyplot as plt

def model(B, t):
    k = 0.05
    V = 50
    dBdt = -k * B + V * np.sin(np.pi * t / 12)
    return dBdt

B0 = 1000
t = np.linspace(0, 48, 49)
B = odeint(model, B0, t).ravel()

plt.figure(figsize=(10, 6))
plt.plot(t, B, 'r-o', markersize=5, linewidth=1.5, label='Battery Level with Periodic Charging')
plt.xlabel('Time (hours)')
plt.ylabel('Battery Level (mAh)')
plt.title('Battery Level Fluctuation in an IoT Device')
plt.legend()
plt.grid(True)
plt.xlim(0, 50)
plt.ylim(0, 1000)
plt.show()
